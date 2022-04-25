package dummy

import dummy.coo.COO
import dummy.EData
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

class Service6 {
    fun send(any: Any) {
    }
}

class Service5 {
    fun u(a: UUID, s: String) {
    }
}

class Service1 {
    fun r(any: Any) {
    }
}

interface Service4 : JpaRepository<EData, Long> {
    fun f(COO: COO): EData?
}
