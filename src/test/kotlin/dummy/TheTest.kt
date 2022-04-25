package dummy

import dummy.coo.CA
import dummy.coo.COO
import dummy.coo.COORepository
import dummy.coo.CS
import dummy.cuu.CE
import dummy.cuu.CR
import dummy.cuu.CUU
import dummy.cuu.CUURepository
import io.mockk.*
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import java.time.LocalDate
import java.util.*

@ExtendWith(MockKExtension::class)
internal class TheTest {

    lateinit var service1: Service1

    @MockK(relaxed = true)
    lateinit var customerRepository: CUURepository

    @MockK(relaxed = true)
    lateinit var COORepository: COORepository

    @MockK(relaxed = true)
    lateinit var service4: Service4

    @MockK(relaxed = true)
    lateinit var service5: Service5

    @MockK
    lateinit var service6: Service6

    @BeforeEach
    fun setup() {
        service1 = Service1()
    }

    @Test
    fun `receive OK in N, case2`() {
        val something = Something()
        val company = company()
        val cuus = listOf(
            CUU(
                UUID.fromString("550e8400-e29b-11d4-a716-446655440000"), "f1", "s1", "l1", "e1",
                LocalDate.now(), CE.I, CR.H
            ),
            CUU(
                UUID.fromString("550e8400-e29b-11d4-a716-999999999999"), "f2", "s2", "l2", "e2",
                LocalDate.now(), CE.I, CR.H
            ),
        )

        every { COORepository.findById(42) } returns Optional.of(company)
        every { service4.f(company) } returns null
        every { service4.save(any()) } returns mockk()
        every { customerRepository.find(company) } returns cuus
        every { service6.send(any()) } just Runs

        service1.r(something)

        verify { service5.u(cuus[0].uuid, "a") }
        verify { service5.u(cuus[1].uuid, "a") }
        verify(exactly = 2) { service6.send(any()) }
    }


    @Test
    fun `receive R in N, check for mails sent`() {
        val something = Something()
        val company = company()
        val cuus = listOf(
            CUU(
                UUID.fromString("550e8400-e29b-11d4-a716-446655440000"), "f1", "s1", "l1", "e1",
                LocalDate.now(), CE.I, CR.H
            ),
            CUU(
                UUID.fromString("550e8400-e29b-11d4-a716-999999999999"), "f2", "s2", "l2", "e2",
                LocalDate.now(), CE.I, CR.H
            ),
        )
    }

    private fun company(): COO =
        COO(
            a = "a",
            b = "b",
            c = "c",
            d = "d",
            e = CA("a", "b", "c", "d", "e", "f"),
            f = "",
            g = CS.N
        )
}
