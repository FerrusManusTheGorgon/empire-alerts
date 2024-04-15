Empire Arms Notification Service
Project Overview

This Scala application is designed to monitor updates on the Empire Arms website for new postings and send notifications via Telegram when updates are detected. The application leverages Akka's Actor System for managing asynchronous operations and robust error handling, combined with Scala's powerful concurrency features.
Modules and Packages

    Actor System: Manages asynchronous tasks and is used for scheduling operations.
    EmpireArmsChecker: Service to check for updates on the Empire Arms website.
    TelegramServiceImpl: Service to send notifications via Telegram.
    LazyLogging: Used for logging purposes throughout the application.

Technologies Used

    Scala (with Akka Actor System)
    Typesafe Logging (LazyLogging)
    Selenium WebDriver for website interaction (not directly mentioned but implied for similar applications)
    Telegram API for sending notifications

Setup and Installation
Prerequisites

    JDK 8 or above.
    SBT (Scala Build Tool) installed.
    An active Telegram bot token and chat ID for sending notifications.

Configuring the Application

    Clone the repository to your local machine.
    Ensure that you have the necessary credentials for the Telegram bot:
        Bot token
        Chat ID
    Update the application.conf file (if exists) or directly insert your Telegram bot token and chat ID into the TelegramServiceImpl class.
    Key Functionalities

    Website Monitoring: Continuously checks the specified Empire Arms webpage for changes or updates.
    Notification: Sends an automated message to a specified Telegram chat when updates are detected.

Architecture

    The application initializes an ActorSystem which is used to manage various asynchronous operations.
    The EmpireArmsChecker class is responsible for fetching and checking content from the Empire Arms website.
    Upon detecting updates, the TelegramServiceImpl is invoked to send notifications through the Telegram API.

Error Handling

    The application includes retry mechanisms to handle transient failures during web access or when sending notifications.
    Logging is implemented extensively to track the flow of operations and errors.
