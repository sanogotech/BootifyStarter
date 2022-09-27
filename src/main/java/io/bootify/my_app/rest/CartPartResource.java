package io.bootify.my_app.rest;

import io.bootify.my_app.model.CartPartDTO;
import io.bootify.my_app.service.CartPartService;
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
@RequestMapping(value = "/api/cartParts", produces = MediaType.APPLICATION_JSON_VALUE)
public class CartPartResource {

    private final CartPartService cartPartService;

    public CartPartResource(final CartPartService cartPartService) {
        this.cartPartService = cartPartService;
    }

    @GetMapping
    public ResponseEntity<List<CartPartDTO>> getAllCartParts() {
        return ResponseEntity.ok(cartPartService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartPartDTO> getCartPart(@PathVariable final Long id) {
        return ResponseEntity.ok(cartPartService.get(id));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createCartPart(@RequestBody @Valid final CartPartDTO cartPartDTO) {
        return new ResponseEntity<>(cartPartService.create(cartPartDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCartPart(@PathVariable final Long id,
            @RequestBody @Valid final CartPartDTO cartPartDTO) {
        cartPartService.update(id, cartPartDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteCartPart(@PathVariable final Long id) {
        cartPartService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
