package kr.ac.kopo.guestbook2024.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import javax.xml.stream.events.DTD;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class PageResultDto<DTO, ENT> {
    private List<DTO> dtoList;

    public PageResultDto(Page<ENT> result, Function<ENT, DTO> fn){
        dtoList = result.stream().map(fn).collect(Collectors.toList());
    }
}
