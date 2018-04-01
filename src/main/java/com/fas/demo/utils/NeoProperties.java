package com.fas.demo.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class NeoProperties {

    @Value("${com.neo.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;
}
