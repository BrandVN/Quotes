package clase.am.quotes.domain

import clase.am.quotes.domain.Model.QuoteModel
import clase.am.quotes.domain.usecase.GetQuoteUseCase
import kotlinx.coroutines.flow.Flow

interface QuoteRepository {
    suspend fun getQuoteRandom():Flow<QuoteModel>
    suspend fun getQuote(quoteId:Int): Flow<QuoteModel>
}