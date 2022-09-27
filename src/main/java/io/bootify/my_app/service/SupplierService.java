package io.bootify.my_app.service;

import io.bootify.my_app.domain.Supplier;
import io.bootify.my_app.model.SupplierDTO;
import io.bootify.my_app.repos.SupplierRepository;
import io.bootify.my_app.util.WebUtils;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(final SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<SupplierDTO> findAll() {
        return supplierRepository.findAll(Sort.by("id"))
                .stream()
                .map(supplier -> mapToDTO(supplier, new SupplierDTO()))
                .collect(Collectors.toList());
    }

    public SupplierDTO get(final Long id) {
        return supplierRepository.findById(id)
                .map(supplier -> mapToDTO(supplier, new SupplierDTO()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Long create(final SupplierDTO supplierDTO) {
        final Supplier supplier = new Supplier();
        mapToEntity(supplierDTO, supplier);
        return supplierRepository.save(supplier).getId();
    }

    public void update(final Long id, final SupplierDTO supplierDTO) {
        final Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        mapToEntity(supplierDTO, supplier);
        supplierRepository.save(supplier);
    }

    public void delete(final Long id) {
        supplierRepository.deleteById(id);
    }

    private SupplierDTO mapToDTO(final Supplier supplier, final SupplierDTO supplierDTO) {
        supplierDTO.setId(supplier.getId());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setActive(supplier.getActive());
        return supplierDTO;
    }

    private Supplier mapToEntity(final SupplierDTO supplierDTO, final Supplier supplier) {
        supplier.setName(supplierDTO.getName());
        supplier.setActive(supplierDTO.getActive());
        return supplier;
    }

    @Transactional
    public String getReferencedWarning(final Long id) {
        final Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        if (!supplier.getSupplierCartParts().isEmpty()) {
            return WebUtils.getMessage("supplier.cartPart.manyToOne.referenced", supplier.getSupplierCartParts().iterator().next().getId());
        }
        return null;
    }

}
