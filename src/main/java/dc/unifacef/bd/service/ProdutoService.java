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


    // Atualiza um produto por id e o produto alterado
    public Produto atualiza(Long id, Produto alterado){
        // Verifica se o produto exsite no BD
        if(repo.existsById(id)){
            alterado.setId(id);

            // ISSO CAI NA PROVA
            repo.save(alterado);    // Como alterado tem id = Ele faz UPDATE
        }
        return null; // Quando o produto não existe
    }
    // Metodo pra inserir o produto no banco (criar)
    public Produto salva(Produto produto){
        return repo.save(produto);  // Como o produto não tem ID, ele faz INSERT (somente coloca la)
    }
}