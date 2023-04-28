package com.azdevelopment.webproject.controller;

import com.azdevelopment.webproject.dto.UserDTO;
import com.azdevelopment.webproject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary = "Listagem de Usuários",
            description = "Listagem de Usuários",
            tags = {"Listagem de Usuários"})
    @ApiResponse(responseCode = "200", description = "Listagem de Usuários")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))
                    )})})
    @GetMapping("/all")
    public List<UserDTO> getUser() {
        return this.userService.getUser();
    }

    @Operation(summary = "Pesquisa de Usuário por ID",
            description = "Pesquisa de Usuário por ID",
            tags = {"Pesquisa de Usuário por ID"})
    @ApiResponse(responseCode = "200", description = "Pesquisa de Usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))
                    )})})
    @GetMapping("/{id}")
    public UserDTO getID(@PathVariable String id) {
        return this.userService.getID(id);
    }

    @Operation(summary = "Criação de Usuário",
            description = "Criação de Usuário",
            tags = {"Criar"})
    @ApiResponse(responseCode = "200", description = "Criação de Usuário")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))
                    )})})
    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO user){
        return userService.create(user);
    }

    @Operation(summary = "Excluir Usuário por ID",
            description = "Excluir Usuário por ID",
            tags = {"Apagar"})
    @ApiResponse(responseCode = "200", description = "Excluir Usuário por ID")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))
                    )})})
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id)  {
        userService.delete(id);
    }

    @Operation(summary = "Atualizar Usuário",
            description = "Atualizar Usuário",
            tags = {"Atualizar"})
    @ApiResponse(responseCode = "200", description = "Atualizar Usuário")
    @ApiResponses(value = {
            @ApiResponse(content = {
                    @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = UserDTO.class))
                    )})})
    @PutMapping("/update")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO user){
        return ResponseEntity.ok(this.userService.update(user));
    }
}
