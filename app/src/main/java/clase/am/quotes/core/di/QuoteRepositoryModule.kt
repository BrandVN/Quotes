package clase.am.quotes.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import clase.am.quotes.data.local.QuoteRepositoryImpl
import clase.am.quotes.data.local.QuoteLocalDataSource
import clase.am.quotes.data.local.QuoteLocalDataSourceImpl
import clase.am.quotes.domain.QuoteRepository


@Module
@InstallIn(SingletonComponent::class)
abstract class QuoteRepositoryModule {

    @Binds
    abstract fun bindQuoteRepository(quoteRepositoryImpl: QuoteRepositoryImpl):
            QuoteRepository

    @Binds
    abstract fun bindQuoteLocalDataSource(quoteLocalDataSourceImpl: QuoteLocalDataSourceImpl):
            QuoteLocalDataSource

}