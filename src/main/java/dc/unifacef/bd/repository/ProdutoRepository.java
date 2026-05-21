package dc.unifacef.bd.repository;

import dc.unifacef.bd.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;


// É a classe que mais se aproxima do Banco de Dados
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Essa interface vai conter os métodos de CRUD da tabela produto
    // save(), findAll(), findById(), remove(), existsById(), count()
}