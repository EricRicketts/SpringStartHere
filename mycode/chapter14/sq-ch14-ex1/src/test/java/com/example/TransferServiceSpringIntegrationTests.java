package com.example;

import com.example.model.Account;
import com.example.repositories.AccountRepository;
import com.example.services.TransferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class TransferServiceSpringIntegrationTests {

  @MockBean
  private AccountRepository accountRepository;

  @Autowired
  private TransferService transferService;

  @Test
  void transferServiceTransferAmountTest() {
    Account sender = new Account();
    sender.setId(1);
    sender.setAmount(new BigDecimal(1000));

    Account receiver = new Account();
    receiver.setId(2);
    receiver.setAmount(new BigDecimal(1000));

    when(accountRepository.findById(1L)).thenReturn(Optional.of(sender));
    when(accountRepository.findById(2L)).thenReturn(Optional.of(receiver));

    transferService.transferMoney(1, 2, new BigDecimal(100));

    verify(accountRepository).changeAmount(1, new BigDecimal(900));
    verify(accountRepository).changeAmount(2, new BigDecimal(1100));
  }

}
