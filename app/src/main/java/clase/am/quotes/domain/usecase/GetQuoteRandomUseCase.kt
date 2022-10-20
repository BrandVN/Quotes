package clase.am.quotes.domain.usecase

import clase.am.quotes.domain.QuoteRepository
import clase.am.quotes.domain.Model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor( private val quoteRepository: QuoteRepository) {
    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()

}