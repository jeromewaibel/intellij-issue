package dummy.cuu

import dummy.coo.COO
import org.modelmapper.ModelMapper
import java.time.LocalDate
import java.util.*
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
class CUU(

    @Id
    @Column(updatable = false)
    val uuid: UUID,

    @field:Email(message = "invalid")
    @field:NotNull
    @field:NotEmpty
    @Column
    var email: String,

    @field:NotNull
    var salutation: String,

    @Column
    @field:NotNull
    @field:NotEmpty
    var firstName: String,

    @Column
    @field:NotNull
    @field:NotEmpty
    var lastName: String,

    var birthDate: LocalDate? = null,

    @Enumerated(EnumType.STRING)
    @field:NotNull
    var state: CE,

    @Enumerated(EnumType.STRING)
    @field:NotNull
    var role: CR,

    @Valid
    @ManyToOne(fetch = FetchType.LAZY)
    var COO: COO? = null,

    )
{
    companion object {
        val modelMapper = ModelMapper().apply {
            this.typeMap(CUU::class.java, CUU::class.java)
                .addMappings { it.skip(CUU::role.setter) }
                .addMappings { it.skip(CUU::state.setter) }
                .addMappings { it.skip(CUU::COO.setter) }
        }
    }
}
