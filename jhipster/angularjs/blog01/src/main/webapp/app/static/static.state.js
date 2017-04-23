(function() {
    'use strict';

    angular
        .module('blog01App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider.state('static', {
            parent: 'app',
            url: '/static',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'Static'
            },
            views: {
                'content@': {
                    templateUrl: 'app/static/static.html',
                    controller: 'StaticController',
                    controllerAs: 'vm'
                }
            }
        });
    }
})();
