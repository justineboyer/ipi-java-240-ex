package com.ipiecoles.java.java240;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;


@SpringBootApplication
// @Configuration
// @ComponentScan("com.ipiecoles.java.java240")
// @PropertySource("classpath:application.properties")
public class SpringConfig {
    //beans
@Value("${bitcoinService.forceRefresh}")
Boolean forceRefresh;

    @Bean(name = "bitcoinServiceWithoutCache")
    @Qualifier ("withoutCache")
    @Scope("singleton")//Facultatif car par défaut
    public BitcoinService bitcoinServiceWithoutCache(){
        BitcoinService bitcoinService = new BitcoinService();
        bitcoinService.setForceRefresh(forceRefresh);
   //     bitcoinService.setWebPageManager(webPageManager());
        return bitcoinService;
    }

    public static void main(String[]args) {
    SpringApplication.run(SpringConfig.class, args);
    }
}

    // @Bean(name = "bitcoinServiceWithCache")
   // public BitcoinService bitcoinServiceWithCache(){
    //    BitcoinService bitcoinService = new BitcoinService();
     //   bitcoinService.setForceRefresh(false);
    //    bitcoinService.setWebPageManager(webPageManager());
   //     return bitcoinService;
   // }


  //  @Bean
   // public WebPageManager webPageManager(){
    //    return new WebPageManager();
   // }

   // @Bean
   // public ProduitManager produitManager(){
   //     ProduitManager produitManager = new ProduitManager();
   //     produitManager.setBitcoinService(bitcoinServiceWithoutCache());
   //     produitManager.setWebPageManager(webPageManager());
   //     return produitManager;
  //  }






