package com.cpt.payments.config;

import com.cpt.payments.constants.*;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapping from DTO to Entity
        modelMapper.addMappings(new PropertyMap<TransactionDTO, TransactionEntity>() {
            @Override
            protected void configure() {
                using(ctx -> TransactionStatusEnum.codeFromName((String) ctx.getSource()))
                        .map(source.getTxnStatus(), destination.getTxnStatusId());

                using(ctx -> PaymentMethodEnum.codeFromName((String) ctx.getSource()))
                        .map(source.getPaymentMethod(), destination.getPaymentMethodId());

                using(ctx -> ProviderEnum.codeFromName((String) ctx.getSource()))
                        .map(source.getProviderName(), destination.getProviderId());

                using(ctx -> PaymentProviderEnum.codeFromName((String) ctx.getSource()))
                        .map(source.getPaymentType(), destination.getPaymentProviderId());
            }
        });
        modelMapper.addMappings(new PropertyMap<TransactionEntity, TransactionDTO>() {
            @Override
            protected void configure() {
                using(ctx->TransactionStatusEnum.fromCode((Integer) ctx.getSource()).name())
                        .map(source.getTxnStatusId(),destination.getTxnStatus());
            }
        });

        return modelMapper;
    }
}
