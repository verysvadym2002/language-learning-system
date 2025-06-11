package cz.fei.upce.language_learning_system.mapper;

import cz.fei.upce.language_learning_system.dto.KurzRequestDto;
import cz.fei.upce.language_learning_system.dto.KurzResponseDto;
import cz.fei.upce.language_learning_system.entity.Kurz;

//@Mapper(componentModel = "spring")
public class CourseMapper {
//    @Mapping(source = "language", target = "language")
//    @Mapping(source = "description", target = "description")
//    KurzResponseDto toResponseDto(Kurz kurz);
//
//    Kurz toEntity(KurzRequestDto kurzRequestDto);

    public KurzResponseDto toDto(Kurz kurz){
        if (kurz == null) {
            return null;
        }
        KurzResponseDto dto = new KurzResponseDto();
        dto.setId(kurz.getId());
        dto.setLanguage(kurz.getLanguage());
        dto.setDescription(kurz.getDescription());
        return dto;
    }

    public Kurz toEntity(KurzRequestDto kurzRequestDto) {
        if (kurzRequestDto == null) {
            return null;
        }
        Kurz kurz = new Kurz();
        kurz.setLanguage(kurzRequestDto.getLanguage());
        kurz.setDescription(kurzRequestDto.getDescription());
        return kurz;
    }
}
