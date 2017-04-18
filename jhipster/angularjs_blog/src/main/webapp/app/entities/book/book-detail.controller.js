(function() {
    'use strict';

    angular
        .module('angularjsBlogApp')
        .controller('BookDetailController', BookDetailController);

    BookDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Book', 'Author'];

    function BookDetailController($scope, $rootScope, $stateParams, previousState, entity, Book, Author) {
        var vm = this;

        vm.book = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('angularjsBlogApp:bookUpdate', function(event, result) {
            vm.book = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
