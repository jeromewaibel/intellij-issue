package dummy.coo

import org.modelmapper.ModelMapper
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
class COO(

    @field:NotNull(message = "invalid")
    @field:NotEmpty
    var a: String,

    @field:NotNull
    @field:NotEmpty
    var b: String,

    @field:NotNull
    @field:NotEmpty
    var c: String,

    @field:NotNull
    var d: String,

    @Embedded
    @field:Valid
    @field:NotNull
    var e: CA,

    @field:NotNull
    @field:NotEmpty
    var f: String,

    @Enumerated(EnumType.STRING)
    @field:NotNull
    var g: CS = CS.C,
) {

    companion object {
        val modelMapper = ModelMapper().apply {
            this.typeMap(COO::class.java, COO::class.java)
                .addMappings { it.skip(COO::id.setter) }
                .addMappings {
                    it.skip(COO::g.setter)
                }
        }
    }

    @Id
    @GeneratedValue
    var id: Long = 0

}


@Embeddable
class CA(
    @field:NotNull
    var a: String,

    @field:NotNull
    @field:NotEmpty
    var b: String,

    @field:NotNull
    @field:NotEmpty
    var c: String,

    @field:NotNull
    @field:NotEmpty
    var d: String,

    @field:NotNull
    @field:NotEmpty
    var e: String,

    @field:NotNull
    @field:NotEmpty
    var f: String,
)
