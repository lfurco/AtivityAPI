package dc.unifacef.bd.service;

import dc.unifacef.bd.model.Produto;
import dc.unifacef.bd.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    // A injeção de dependência será pelo construtor
    private ProdutoRepository repo;

    // Toda vez ele vai inicializar assim
    public ProdutoService(ProdutoRepository repo){
        this.repo = repo;
    }

    // Listar os produtos da tabela produtos
    public List<Produto> listar(){
        return repo.findAll();
    }

    // Listar os produtos da tabela PRODUTOS por um ID
    public Optional<Produto> buscarPorId(Long id){
        return repo.findById(id);   // Pode ou não retornar um produto (Optional)
    }

    // Remove um produto da tabela produtos
    public boolean remove(Long id) {
        if (repo.existsById(id)) {// Se ele existir, retorna TRUE
            repo.deleteById(id);
            return true; // remove
        }
        return false; // Não remove
    }
}
