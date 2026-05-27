package com.ycon.pedidos_api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepository repository;

    @GetMapping
    public List<Pedido> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Pedido criar(@RequestBody Pedido pedido) {
        pedido.setStatus("PENDENTE");
        return repository.save(pedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
        return repository.findById(id).map(p -> {
            p.setDescricao(pedido.getDescricao());
            p.setValor(pedido.getValor());
            p.setStatus(pedido.getStatus());
            return ResponseEntity.ok(repository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}