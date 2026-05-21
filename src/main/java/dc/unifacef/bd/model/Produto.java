package dc.unifacef.bd.model;

import jakarta.persistence.*;

@Entity
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)  // É obrigatorio algo no nome
    private String nome;
    @Column (nullable = false)
    private Double preco;
    @Column (length = 500)  // No máximo 500 caracteres
    private String descricao;


}
