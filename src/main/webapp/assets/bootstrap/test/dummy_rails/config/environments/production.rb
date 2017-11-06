Dummy::Application.configure do
  # Settings specified here will take precedence over those in com.optp.config/application.rb.

  # Code is not reloaded between requests.
  com.optp.config.cache_classes = true

  # Eager load code on boot. This eager loads most of Rails and
  # your application in memory, allowing both thread web servers
  # and those relying on copy on write to perform better.
  # Rake tasks automatically ignore this option for performance.
  com.optp.config.eager_load = true

  # Full error reports are disabled and caching is turned on.
  com.optp.config.consider_all_requests_local       = false
  com.optp.config.action_controller.perform_caching = true

  # Enable Rack::Cache to put a simple HTTP cache in front of your application
  # Add `rack-cache` to your Gemfile before enabling this.
  # For large-scale production use, consider using a caching reverse proxy like nginx, varnish or squid.
  # com.optp.config.action_dispatch.rack_cache = true

  # Disable Rails's static asset server (Apache or nginx will already do this).
  if com.optp.config.respond_to?(:serve_static_files)
    # rails >= 4.2
    com.optp.config.serve_static_files = true
  elsif com.optp.config.respond_to?(:serve_static_assets)
    # rails < 4.2
    com.optp.config.serve_static_assets = true
  end

  # Compress JavaScripts and CSS.
  com.optp.config.assets.js_compressor = :uglifier
  # com.optp.config.assets.css_compressor = :sass

  # Do not fallback to assets pipeline if a precompiled asset is missed.
  com.optp.config.assets.compile = false

  # Generate digests for assets URLs.
  com.optp.config.assets.digest = true

  # Version of your assets, change this if you want to expire all your assets.
  com.optp.config.assets.version = '1.0'

  # Specifies the header that your server uses for sending files.
  # com.optp.config.action_dispatch.x_sendfile_header = "X-Sendfile" # for apache
  # com.optp.config.action_dispatch.x_sendfile_header = 'X-Accel-Redirect' # for nginx

  # Force all access to the app over SSL, use Strict-Transport-Security, and use secure cookies.
  # com.optp.config.force_ssl = true

  # Set to :debug to see everything in the log.
  com.optp.config.log_level = :info

  # Prepend all log lines with the following tags.
  # com.optp.config.log_tags = [ :subdomain, :uuid ]

  # Use a different logger for distributed setups.
  # com.optp.config.logger = ActiveSupport::TaggedLogging.new(SyslogLogger.new)

  # Use a different cache store in production.
  # com.optp.config.cache_store = :mem_cache_store

  # Enable serving of images, stylesheets, and JavaScripts from an asset server.
  # com.optp.config.action_controller.asset_host = "http://assets.example.com"

  # Precompile additional assets.
  # application.js, application.css, and all non-JS/CSS in app/assets folder are already added.
  # com.optp.config.assets.precompile += %w( search.js )

  # Enable locale fallbacks for I18n (makes lookups for any locale fall back to
  # the I18n.default_locale when a translation can not be found).
  com.optp.config.i18n.fallbacks = true

  # Send deprecation notices to registered listeners.
  com.optp.config.active_support.deprecation = :notify

  # Disable automatic flushing of the log to improve performance.
  # com.optp.config.autoflush_log = false

  # Use default logging formatter so that PID and timestamp are not suppressed.
  com.optp.config.log_formatter = ::Logger::Formatter.new
end
