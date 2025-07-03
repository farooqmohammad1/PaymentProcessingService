package com.cpt.payments.config;

import com.cpt.payments.constants.*;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

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
                when(Objects::nonNull)
                        .using(ctx->TransactionStatusEnum.fromCode((Integer) ctx.getSource()).name())
                        .map(source.getTxnStatusId(),destination.getTxnStatus());
                when(Objects::nonNull)
                        .using(ctx->PaymentMethodEnum.fromCode((Integer) ctx.getSource()).name())
                        .map(source.getPaymentMethodId(),destination.getPaymentMethod());
                when(Objects::nonNull)
                        .using(ctx->ProviderEnum.fromCode((Integer) ctx.getSource()).name())
                        .map(source.getProviderId(),destination.getProviderName());
                when(Objects::nonNull)

                        .using(ctx -> PaymentProviderEnum.fromCode((Integer) ctx.getSource()).getName())
                        .map(source.getPaymentProviderId(), destination.getPaymentType());
            }
        });

        return modelMapper;
    }

}
