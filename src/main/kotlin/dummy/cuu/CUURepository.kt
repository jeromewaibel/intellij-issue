package dummy.cuu

import dummy.coo.COO
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CUURepository : JpaRepository<CUU, UUID> {

    fun find(COO: COO): Iterable<CUU>

}
