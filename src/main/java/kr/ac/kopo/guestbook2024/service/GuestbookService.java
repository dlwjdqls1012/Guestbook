package kr.ac.kopo.guestbook2024.service;

import com.querydsl.core.BooleanBuilder;
import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import kr.ac.kopo.guestbook2024.dto.PageRequestDTO;
import kr.ac.kopo.guestbook2024.entity.QGuestbook;

public interface GuestbookService  {
    Long register(GuestbookDTO dto);
    PageRequestDTO getList(PageRequestDTO resultDto);
    GuestbookDTO read(Long gno);

    void modify(GuestbookDTO dto);

    void remove(Long gno);

    BooleanBuilder getSearch(PageRequestDTO requestDTO);

    default QGuestbook dtoToEntity(GuestbookDTO dto){

        QGuestbook entity = QGuestbook.bulider()
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

    GuestbookDTO read(Long gno);
}
