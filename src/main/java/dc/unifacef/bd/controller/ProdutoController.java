package dc.unifacef.bd.controller;

import dc.unifacef.bd.model.Produto;
import dc.unifacef.bd.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // Ele recebe as requisições HTTP
@RequestMapping("/produtos")

public class ProdutoController {
    // Vamos usar o objeto da classe ProdutoService - Injeção de dependência
    // Vamos usar o construtor pra isso

    private ProdutoService service;
    public ProdutoController(ProdutoService service){
        this.service = service;
    }

    // Por que usar ResponseEntity? Para retornar diferentes statusCode ao FE
    @GetMapping
    public ResponseEntity<List<Produto>> listar(){
        return ResponseEntity.ok(service.listar()); // statusCode: 200 - OK
    }
}