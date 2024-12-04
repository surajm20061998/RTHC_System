# healthcare_project/asgi.py
import os
from channels.routing import get_default_application
from django.core.asgi import get_asgi_application

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'healthcare_project.settings')
django_asgi_app = get_asgi_application()

import healthcare_app.routing

application = ProtocolTypeRouter({
    'http': django_asgi_app,
    'websocket': healthcare_app.routing.websocket_urlpatterns,
})
