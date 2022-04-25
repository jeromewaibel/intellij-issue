package dummy.coo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface COORepository : JpaRepository<COO, Long>

