package kg.peaksoft.bilingualb6.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "options")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Option {

    @Id
    @GeneratedValue(generator = "option_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "option_generator", sequenceName = "option_id_sequence", allocationSize = 1)
    private Long id;

    @Column(length = 10000)
    private String option;

    private Boolean isTrue;

    @ManyToOne(cascade = {MERGE, DETACH, REFRESH})
    @JsonIgnore
    private Question question;
}
