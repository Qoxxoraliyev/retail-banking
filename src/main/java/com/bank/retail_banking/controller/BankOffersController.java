package com.bank.retail_banking.controller;

import com.bank.retail_banking.dto.BankOffersRequestDTO;
import com.bank.retail_banking.dto.BankOffersResponseDTO;
import com.bank.retail_banking.entity.BankOffers;
import com.bank.retail_banking.mapper.BankOffersMapper;
import com.bank.retail_banking.service.BankOffersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank-offers")
@RequiredArgsConstructor
public class BankOffersController {

    private final BankOffersService bankOffersService;

    private final BankOffersMapper bankOffersMapper;

    @PostMapping
    public ResponseEntity<BankOffersResponseDTO> createOffer(@RequestBody BankOffersRequestDTO requestDTO){
        BankOffers offer=bankOffersService.createOffer(
                requestDTO.bankId(),
                requestDTO.offerName(),
                requestDTO.offerDescription(),
                requestDTO.offerType(),
                requestDTO.value(),
                requestDTO.budget(),
                requestDTO.startDate(),
                requestDTO.endDate()
                );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(bankOffersMapper.toResponseDTO(offer));
    }



    @DeleteMapping("/{offerId}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long offerId) {
        bankOffersService.deleteOffer(offerId);
        return ResponseEntity.noContent().build();
    }



}
