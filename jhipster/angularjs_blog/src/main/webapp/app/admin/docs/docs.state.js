(function() {
    'use strict';

    angular
        .module('angularjsBlogApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig ($stateProvider) {
        $stateProvider.state('docs', {
            parent: 'admin',
            url: '/docs',
            data: {
                authorities: ['ROLE_ADMIN'],
                pageTitle: 'API'
            },
            views: {
                'content@': {
                    templateUrl: 'app/admin/docs/docs.html'
                }
            }
        });
    }
})();
