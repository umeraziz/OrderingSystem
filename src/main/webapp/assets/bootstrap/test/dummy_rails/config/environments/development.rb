Dummy::Application.configure do
  # Settings specified here will take precedence over those in com.optp.config/application.rb.

  # In the development environment your application's code is reloaded on
  # every request. This slows down response time but is perfect for development
  # since you don't have to restart the web server when you make code changes.
  com.optp.config.cache_classes = false

  # Do not eager load code on boot.
  com.optp.config.eager_load = false

  # Show full error reports and disable caching.
  com.optp.config.consider_all_requests_local       = true
  com.optp.config.action_controller.perform_caching = false

  # Print deprecation notices to the Rails logger.
  com.optp.config.active_support.deprecation = :log

  # Debug mode disables concatenation and preprocessing of assets.
  # This option may cause significant delays in view rendering with a large
  # number of complex assets.
  com.optp.config.assets.debug = true
end
