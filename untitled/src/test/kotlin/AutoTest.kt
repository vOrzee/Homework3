import org.junit.Test
import kotlin.test.assertEquals

class AutoTest {
    @Test
    fun testMir() {
        val cardType: String = "Мир"
        val transferAmount = 10_000
        val previousTransfers = 0
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(0, result)

    }

    @Test
    fun testVisa() {
        val cardType = "Visa"
        val transferAmount = 1000
        val previousTransfers = 0
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(35, result)
    }

    @Test
    fun test_MaximumCommissionVisa() {
        val cardType = "Visa"
        val transferAmount = 10_000
        val previousTransfers = 0
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(75, result)
    }

    @Test
    fun testMasterCard() {
        val cardType = "Mastercard"
        val transferAmount = 0
        val previousTransfers = 76_000
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(20, result)

    }

    @Test
    fun testMasterCardGrande() {
        val cardType = "Mastercard"
        val transferAmount = 76_000
        val previousTransfers = 56_000
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(362, result)


    }

    @Test
    fun testMasterCardMin() {
        val cardType = "Mastercard"
        val transferAmount = 0
        val previousTransfers = 0
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(0, result)

    }

    @Test
    fun ErrorType() {
        val cardType = "MoestroCard"
        val transferAmount = 0
        val previousTransfers = 0
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(-1, result)
    }

    @Test
    fun maxLimitTransferAmount() {
        val cardType = "Mastercard"
        val transferAmount = 160_000
        val previousTransfers = 0
        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(-1, result)
    }

    @Test
    fun maxLimitTransfer() {
        val cardType = "Mastercard"
        val transferAmount = 140_000
        val previousTransfers = 500_000


        val result = calculateCommission(
            cardType = cardType,
            transferAmount = transferAmount,
            previousTransfers = previousTransfers
        )
        assertEquals(-1, result)
    }
}