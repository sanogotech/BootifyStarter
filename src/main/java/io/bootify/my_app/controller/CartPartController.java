package io.bootify.my_app.controller;

import io.bootify.my_app.domain.Supplier;
import io.bootify.my_app.model.CartPartDTO;
import io.bootify.my_app.repos.SupplierRepository;
import io.bootify.my_app.service.CartPartService;
import io.bootify.my_app.util.WebUtils;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/cartParts")
public class CartPartController {

    private final CartPartService cartPartService;
    private final SupplierRepository supplierRepository;

    public CartPartController(final CartPartService cartPartService,
            final SupplierRepository supplierRepository) {
        this.cartPartService = cartPartService;
        this.supplierRepository = supplierRepository;
    }

    @ModelAttribute
    public void prepareContext(final Model model) {
        model.addAttribute("supplierValues", supplierRepository.findAll().stream().collect(
                Collectors.toMap(Supplier::getId, Supplier::getName)));
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("cartParts", cartPartService.findAll());
        return "cartPart/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("cartPart") final CartPartDTO cartPartDTO) {
        return "cartPart/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("cartPart") @Valid final CartPartDTO cartPartDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "cartPart/add";
        }
        cartPartService.create(cartPartDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("cartPart.create.success"));
        return "redirect:/cartParts";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable final Long id, final Model model) {
        model.addAttribute("cartPart", cartPartService.get(id));
        return "cartPart/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable final Long id,
            @ModelAttribute("cartPart") @Valid final CartPartDTO cartPartDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "cartPart/edit";
        }
        cartPartService.update(id, cartPartDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("cartPart.update.success"));
        return "redirect:/cartParts";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable final Long id, final RedirectAttributes redirectAttributes) {
        cartPartService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("cartPart.delete.success"));
        return "redirect:/cartParts";
    }

}
