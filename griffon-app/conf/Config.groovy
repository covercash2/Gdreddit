application {
    title = 'gdreddit'
    startupGroups = ['main']
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "main"
    'main' {
        model       = 'com.github.covercash2.gdreddit.MainModel'
        view        = 'com.github.covercash2.gdreddit.MainView'
        controller  = 'com.github.covercash2.gdreddit.MainController'
    }

    'login' {
        model       = 'com.github.covercash2.gdreddit.LoginModel'
        view        = 'com.github.covercash2.gdreddit.LoginView'
        controller  = 'com.github.covercash2.gdreddit.LoginController'
    }

    'feed' {
        model       = 'com.github.covercash2.gdreddit.FeedModel'
        view        = 'com.github.covercash2.gdreddit.FeedView'
        controller  = 'com.github.covercash2.gdreddit.FeedController'
    }

    'navbar' {
        model       = 'com.github.covercash2.gdreddit.NavBarModel'
        view        = 'com.github.covercash2.gdreddit.NavBarView'
        controller  = 'com.github.covercash2.gdreddit.NavBarController'
    }

    'sidebar' {
        model       = 'com.github.covercash2.gdreddit.SideBarModel'
        view        = 'com.github.covercash2.gdreddit.SideBarView'
        controller  = 'com.github.covercash2.gdreddit.SideBarController'
    }
}