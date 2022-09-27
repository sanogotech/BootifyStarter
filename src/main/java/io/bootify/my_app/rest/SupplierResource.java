package io.bootify.my_app.rest;

import io.bootify.my_app.model.SupplierDTO;
import io.bootify.my_app.service.SupplierService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
public class SupplierResource {

    private final SupplierService supplierService;

    public SupplierResource(final SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplier(@PathVariable final Long id) {
        return ResponseEntity.ok(supplierService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createSupplier(@RequestBody @Valid final SupplierDTO supplierDTO) {
        return new ResponseEntity<>(supplierService.create(supplierDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateSupplier(@PathVariable final Long id,
            @RequestBody @Valid final SupplierDTO supplierDTO) {
        supplierService.update(id, supplierDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteSupplier(@PathVariable final Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
