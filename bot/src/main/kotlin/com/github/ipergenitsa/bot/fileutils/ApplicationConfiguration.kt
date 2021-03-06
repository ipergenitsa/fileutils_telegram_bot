package com.github.ipergenitsa.bot.fileutils

import com.github.ipergenitsa.bot.compression.ZipCompression
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
open class ApplicationConfiguration {
    @Bean
    open fun telegramBotsApi() = TelegramBotsApi(DefaultBotSession::class.java)

    @Bean
    open fun config(): Config = ConfigFactory.load()

    @Bean
    open fun parseBotSecurityConfig(
        @Value("#{TELEGRAM_FILE_API_TOKEN}") token: String
    ) = BotSecurityConfig(token)

    @Bean
    open fun compression() = ZipCompression()
}