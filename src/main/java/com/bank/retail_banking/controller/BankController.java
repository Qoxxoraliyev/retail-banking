package com.bank.retail_banking.controller;

import com.bank.retail_banking.dto.BankRequestDTO;
import com.bank.retail_banking.dto.BankResponseDTO;
import com.bank.retail_banking.entity.Bank;
import com.bank.retail_banking.mapper.BankMapper;
import com.bank.retail_banking.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/banks")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;
    private final BankMapper bankMapper;

    @PostMapping
    public ResponseEntity<BankResponseDTO> createBank(
            @RequestBody BankRequestDTO requestDTO
    ) {
        Bank bank = bankMapper.toEntity(requestDTO);
        Bank savedBank = bankService.create(bank);
        BankResponseDTO response =
                bankMapper.toResponseDTO(savedBank);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }


}
