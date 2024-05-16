package kr.ac.kopo.guestbook2024.service;

import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import kr.ac.kopo.guestbook2024.dto.PageRequestDTO;
import kr.ac.kopo.guestbook2024.entity.Guestbook;

public interface GuestbookService  {
    Long register(GuestbookDTO dto);
    PageRequestDTO getList(PageRequestDTO resultDto);

    default Guestbook dtoToEntity(GuestbookDTO dto){

        Guestbook entity = Guestbook.bulider()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .writer(dto.getWriter())
                .content(dto.getContent())
                .build();
        return entity;
    }

    default GuestbookDTO entityToDto(Guestbook entity){
        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}
