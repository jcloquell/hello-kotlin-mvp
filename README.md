# Hello World! - Kotlin MVP

Template to start a new project with a basic **Model-View-Presenter** (MVP) structure written in Kotlin.

For the data layer, an **Interactor** is used as an intermediary of the presenter and the data models.

Also, a **Mapper** is used to map the data models into view models in the **Presenter**, that forwards them to the **View**.

Dagger 2 is used for dependency injection.

----------

**Unit tests** are also provided for the classes that handle some business and view logic (presenter, interactor, mapper).
