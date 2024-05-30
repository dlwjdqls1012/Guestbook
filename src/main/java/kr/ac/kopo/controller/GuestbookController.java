package kr.ac.kopo.controller;

import kr.ac.kopo.guestbook2024.dto.GuestbookDTO;
import kr.ac.kopo.guestbook2024.dto.PageRequestDTO;
import kr.ac.kopo.guestbook2024.service.GuestbookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/guestbook")
public class GuestbookController {
    private final GuestbookService service;

    @GetMapping("/")
    public String index() { return "redirect:/guestbook/list";}

    @GetMapping({"/list"})
    public void list(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("result", service.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void register(){

    }
    @PostMapping("/register")
    public String registerPost(GuestbookDTO dto, RedirectAttributes redirectAttributes) {
        Long gno = service.register(dto);
        redirectAttributes.addFlashAttribute("msg", gno);
        return "redirect:/guestbook/list";
    }

    @GetMapping("/read")
    public void read(Long gno, @ModelAttribute("requestDTO") PageRequestDTO requestDTO, Model model){
        GuestbookDTO dto = service.read(gno);
        model.addAttribute("dto", dto);
    }
}
