package kr.ac.kopo.guestbook2024.dto;

import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.stream.events.DTD;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class PageResultDto<DTO, ENT> {
   //화면에 보여질 글 목록 : GuestbookDTO객체 참조값들이 저장된 리스트
    private List<DTO> dtoList;
   
    //전체 페이지수
    private int totalPage;
    // 현재 페이지 번호
    private int page;
    //한페이지에 보여지는 글목록 개수
    private int size;
    //한화면에 아래쪽에 보여질 시작 페이지 번호
    private int start;
    //한화면에 아래쪽에 보여질 마지막 페이지 번호
    private int end;
    //화면을 바꿔줄 이전, 다음 링크가 보여지거나 보이지 않게 설정할 때 필요
    private boolean prev, next;
    //한 화면에 보여질 페이지 번호 목록이 저장
    private List<Integer> pageList;

    public PageResultDto(Page<ENT> result, Function<ENT, DTO> fn){
        //매개변수로 전달받은 결과행들과 Entity를 DTO로 변환한 fn을 사용해서 GuestbookDTO객체를 저장한 리스트
        dtoList = result.stream().map(fn).collect(Collectors.toList());
        totalPage = result.getTotalPages();
    }

    private void makePageList(Pageable pageable){

    }
}
