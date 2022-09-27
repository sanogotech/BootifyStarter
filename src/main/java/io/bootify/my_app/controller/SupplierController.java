package io.bootify.my_app.controller;

import io.bootify.my_app.model.SupplierDTO;
import io.bootify.my_app.service.SupplierService;
import io.bootify.my_app.util.WebUtils;
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
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(final SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("suppliers", supplierService.findAll());
        return "supplier/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("supplier") final SupplierDTO supplierDTO) {
        return "supplier/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("supplier") @Valid final SupplierDTO supplierDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "supplier/add";
        }
        supplierService.create(supplierDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("supplier.create.success"));
        return "redirect:/suppliers";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable final Long id, final Model model) {
        model.addAttribute("supplier", supplierService.get(id));
        return "supplier/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable final Long id,
            @ModelAttribute("supplier") @Valid final SupplierDTO supplierDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "supplier/edit";
        }
        supplierService.update(id, supplierDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("supplier.update.success"));
        return "redirect:/suppliers";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable final Long id, final RedirectAttributes redirectAttributes) {
        final String referencedWarning = supplierService.getReferencedWarning(id);
        if (referencedWarning != null) {
            redirectAttributes.addFlashAttribute(WebUtils.MSG_ERROR, referencedWarning);
        } else {
            supplierService.delete(id);
            redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("supplier.delete.success"));
        }
        return "redirect:/suppliers";
    }

}
