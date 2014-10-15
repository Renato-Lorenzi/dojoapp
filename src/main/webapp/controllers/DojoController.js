angular.module('DojoApp', [ 'DojoApp.DojoController' ]);

angular.module('DojoApp.DojoController', []).controller('DojoController',
		function($scope) {
			// Dojos objects
			$scope.dojos = [ {
				dateTime : '',
				sensei : 'john',
				moderator : 'maria',
				// Challenge and result of Dojo
				dojoLink : 'https://github.com/Renato-Lorenzi/xcalala',
				challengeLink : 'https://github.com/Renato-Lorenzi/xcalala',
				costCenter : 'tecnologia',
				participants : [ 'joao', 'maria', 'jose' ]
			}, {
				dateTime : '',
				sensei : 'Renato-Lorenzi',
				moderator : 'Jan',
				// Challenge and result of Dojo
				dojoLink : 'https://github.com/Renato-Lorenzi/xcalala',
				costCenter : 'tecnologia',
				participants : [ 'joao', 'maria', 'jose' ]
			} ];

			/**
			 * Add dojo in dojo collection
			 * 
			 * @param dojo
			 *            dojo to insert
			 */
			$scope.addDojo = function(dojo) {
				$scope.dojos.put(dojo);
			}
		});