package com.ipiecoles.java.java240;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfig {
    //beans

    @Bean(name = "bitcoinServiceWithoutCache")
    @Scope("singleton")//Facultatif car par défaut
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(true);
        bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    @Bean(name = "bitcoinServiceWithCache")
    public BitcoinService bitcoinServiceWithCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(false);
        bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }


    @Bean
    public WebPageManager webPageManager(){
        return new WebPageManager();
    }

    @Bean
    public ProduitManager produitManager(){
        ProduitManager produitManager = new ProduitManager();
        produitManager.setBitcoinService(bitcoinServiceWithoutCache());
        produitManager.setWebPageManager(webPageManager());
        return produitManager;
    }
}