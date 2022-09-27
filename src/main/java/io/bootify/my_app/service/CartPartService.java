package io.bootify.my_app.service;

import io.bootify.my_app.domain.CartPart;
import io.bootify.my_app.domain.Supplier;
import io.bootify.my_app.model.CartPartDTO;
import io.bootify.my_app.repos.CartPartRepository;
import io.bootify.my_app.repos.SupplierRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CartPartService {

    private final CartPartRepository cartPartRepository;
    private final SupplierRepository supplierRepository;

    public CartPartService(final CartPartRepository cartPartRepository,
            final SupplierRepository supplierRepository) {
        this.cartPartRepository = cartPartRepository;
        this.supplierRepository = supplierRepository;
    }

    public List<CartPartDTO> findAll() {
        return cartPartRepository.findAll(Sort.by("id"))
                .stream()
                .map(cartPart -> mapToDTO(cartPart, new CartPartDTO()))
                .collect(Collectors.toList());
    }

    public CartPartDTO get(final Long id) {
        return cartPartRepository.findById(id)
                .map(cartPart -> mapToDTO(cartPart, new CartPartDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final CartPartDTO cartPartDTO) {
        final CartPart cartPart = new CartPart();
        mapToEntity(cartPartDTO, cartPart);
        return cartPartRepository.save(cartPart).getId();
    }

    public void update(final Long id, final CartPartDTO cartPartDTO) {
        final CartPart cartPart = cartPartRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(cartPartDTO, cartPart);
        cartPartRepository.save(cartPart);
    }

    public void delete(final Long id) {
        cartPartRepository.deleteById(id);
    }

    private CartPartDTO mapToDTO(final CartPart cartPart, final CartPartDTO cartPartDTO) {
        cartPartDTO.setId(cartPart.getId());
        cartPartDTO.setReleaseDate(cartPart.getReleaseDate());
        cartPartDTO.setTypeCode(cartPart.getTypeCode());
        cartPartDTO.setSupplier(cartPart.getSupplier() == null ? null : cartPart.getSupplier().getId());
        return cartPartDTO;
    }

    private CartPart mapToEntity(final CartPartDTO cartPartDTO, final CartPart cartPart) {
        cartPart.setReleaseDate(cartPartDTO.getReleaseDate());
        cartPart.setTypeCode(cartPartDTO.getTypeCode());
        final Supplier supplier = cartPartDTO.getSupplier() == null ? null : supplierRepository.findById(cartPartDTO.getSupplier())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "supplier not found"));
        cartPart.setSupplier(supplier);
        return cartPart;
    }

}
