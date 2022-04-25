package dummy

import dummy.coo.COO
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity
class EData(
    @field:NotNull
    var a: String,

    var b: String?,

    @OneToOne
    var COO: COO,

    ) {
    @Id
    @GeneratedValue
    val id: Long = 0
}

