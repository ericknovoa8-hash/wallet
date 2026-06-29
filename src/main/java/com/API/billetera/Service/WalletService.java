package com.API.billetera.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.API.billetera.dto.request.WalletRechargeRequestDTO;
import com.API.billetera.dto.request.WalletRequestDTO;
import com.API.billetera.dto.response.MessageResponseDTO;
import com.API.billetera.dto.response.WalletResponseDTO;
import com.API.billetera.entity.Customer;
import com.API.billetera.entity.Wallet;
import com.API.billetera.repository.WalletRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class WalletService {

private final WalletRepository walletRepository;
/**
 * Hacemos el metodo para crear la biletera 
 * @param request
 * @return
 */
public MessageResponseDTO createWallet(WalletRequestDTO request){
    Optional<Wallet> existing = walletRepository.findByCustomerId(request.getCustomerId());
    
    if(existing.isPresent()){
        throw new RuntimeException();
    }
    Wallet wallet = new Wallet();
    Customer customer = new Customer();
    
    customer.setId(request.getCustomerId());
    wallet.setCustomer(customer);
    
    wallet.setBalance(request.getBalance());
    

    walletRepository.save(wallet);

    MessageResponseDTO response = new MessageResponseDTO();
    response.setMessage("Billetera creada correctamente");
    return response;
}
/**
 * Hacemos el metodo de lista para saber el saldo que tiene  y poder recargar la billetera 
 * @return
 */
public List<WalletResponseDTO> getBalance(){
    List<Wallet> wallets = walletRepository.findAll();
    List<WalletResponseDTO> response = new ArrayList<>();

    for (Wallet wallet: wallets){

        WalletResponseDTO dto = new WalletResponseDTO();
        dto.setId(wallet.getId());
        dto.setBalance(wallet.getBalance());
        response.add(dto);
        }
        return response;   
    }
    public WalletResponseDTO rechargeWallet(WalletRechargeRequestDTO request) {
    Wallet wallet = walletRepository.findByCustomerId(request.getCustomerId()).orElseThrow(
        ()-> new RuntimeException("Billetera no encontrada"));

        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El monto debe de ser mayor que cero");
        }
        BigDecimal newBalance = wallet.getBalance().add(request.getAmount());
        wallet.setBalance(newBalance);
        walletRepository.save(wallet);
        
        WalletResponseDTO response = new WalletResponseDTO();
        response.setId(wallet.getId());
        response.setCustomerId(wallet.getCustomer().getId());
        response.setBalance(wallet.getBalance());
        return response;
    }
}
