package com.thymeleaf.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttemptModel {
    String word;
    String letters;
    StringBuilder hided;
}
