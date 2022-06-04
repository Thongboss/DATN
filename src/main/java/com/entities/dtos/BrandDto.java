package com.entities.dtos;

import com.entities.Brand;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BrandDto {
   private Long id;
   private String code;
   private String name;
   private Boolean status;
   private String note;

   public static BrandDto toDto(Brand entity) {
       if (entity == null) {
          throw new RuntimeException("Entity is null");
       }
       return BrandDto.builder()
               .id(entity.getId())
               .code(entity.getCode())
               .name(entity.getName())
               .note(entity.getNote())
               .status(entity.getStatus())
               .build();
   }
}
