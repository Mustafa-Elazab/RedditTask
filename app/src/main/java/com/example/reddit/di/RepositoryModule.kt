package com.example.reddit.di
import com.example.reddit.data.repository.RedditRepositoryImpl
import com.example.reddit.domain.repository.RedditRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {


    @Binds
    abstract fun bindJobRepository(repository: RedditRepositoryImpl): RedditRepository


}